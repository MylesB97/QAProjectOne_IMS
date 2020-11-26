package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
<<<<<<< HEAD
import com.qa.ims.persistence.dao.CustomerDAO;
=======
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
<<<<<<< HEAD
=======
	private final ItemController items;
	private final OrderController orders;
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
	private final Utils utils;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
<<<<<<< HEAD
		this.customers = new CustomerController(custDAO, utils);
=======
		final ItemDAO itemDAO = new ItemDAO();
		final OrderDAO orderDAO = new OrderDAO(itemDAO);
		this.customers = new CustomerController(custDAO, utils);
		this.items = new ItemController(itemDAO, utils);
		this.orders = new OrderController(orderDAO, utils, itemDAO);
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
	}

	public void imsSystem() {
		LOGGER.info("What is your username");
		String username = utils.getString();
		LOGGER.info("What is your password");
		String password = utils.getString();

		DBUtils.connect(username, password);
<<<<<<< HEAD
		Domain domain = null;
=======
		Domain domain =  null;
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
		do {
			LOGGER.info("Which entity would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);
			boolean changeDomain = false;
			do {

				CrudController<?> active = null;
				switch (domain) {
				case CUSTOMER:
					active = this.customers;
					break;
				case ITEM:
<<<<<<< HEAD
					active = null;
					break;
				case ORDER:
					active = null;
=======
					active = this.items;
					break;
				case ORDER:
					active = this.orders;
>>>>>>> 81d2584424cbeb328bae08b88e51a30db0313198
					break;
				case STOP:
					return;
				default:
					break;
				}

				LOGGER.info("What would you like to do with " + domain.name().toLowerCase() + ":");

				Action.printActions();
				Action action = Action.getAction(utils);

				if (action == Action.RETURN) {
					changeDomain = true;
				} else {
					doAction(active, action);
				}
			} while (!changeDomain);
		} while (domain != Domain.STOP);
	}

	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

}
