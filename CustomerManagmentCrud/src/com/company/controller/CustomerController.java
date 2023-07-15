package com.company.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.AdminDao;
import com.company.dao.CustomerDao;
import com.company.model.Customer;


@WebServlet("/")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		switch (path) {
		case "/edit":
			editCustomer(request,response);
			break;
		case "/delete":
			deleteCustomer(request,response);
			break;
		case "/editForm" :
			getEditForm(request,response);
			break;
		case "/insertForm":
			getInsertForm(request,response);
			break;
		case "/add":
			addCustomer(request,response);
			break;
		case "/list":
			validateAdmin(request,response);
			break;
		case "/table":
			getCustomerListPage(request,response);
			break;
		default:
			getStartUpPage(request,response);
			break;
		}
		
	}

	
	private void getCustomerListPage(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			ArrayList<Customer> alCustomers = CustomerDao.getAllCustomer();
			
			RequestDispatcher rd = request.getRequestDispatcher("customer-list.jsp");
			request.setAttribute("al", alCustomers);
			
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void validateAdmin(HttpServletRequest request, HttpServletResponse response) {
		// read data from url
		String n = request.getParameter("tbName");
		String p = request.getParameter("tbPass");
		
		// call dao
		boolean res = AdminDao.validateAdmin(n, p);
		
		// redirect user to list page
		  if(res) {
			  getCustomerListPage(request, response);
		  }else {
			  try {
				response.sendRedirect(request.getContextPath()+"/default");
			} catch (IOException e) { 
				e.printStackTrace();
			}
		  }
	}

	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		int i = Integer.parseInt(request.getParameter("id"));
		
		CustomerDao.deleteCustomer(i);
		
		  getCustomerListPage(request, response);
	}


	private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
		
		int i = Integer.parseInt(request.getParameter("tbEx"));
		String n = request.getParameter("tbName");
		String m = request.getParameter("tbMail");
		Long mob = Long.parseLong(request.getParameter("tbMobile"));
		
		Customer c = new Customer(i,n,m,mob);
		CustomerDao.editCustomer(c);
		
		  getCustomerListPage(request, response);
	}


	private void getEditForm(HttpServletRequest request, HttpServletResponse response) {
		// fetch the data from url
		int i = Integer.parseInt(request.getParameter("id"));
		
		Customer c = CustomerDao.getOneCustomerDetails(i);
		
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("customer-form.jsp");
			request.setAttribute("customer", c);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		
	}


	private void getInsertForm(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			RequestDispatcher rd =request.getRequestDispatcher("customer-form.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		
	}


	private void addCustomer(HttpServletRequest request, HttpServletResponse response) {
		String n = request.getParameter("tbName");
		String m = request.getParameter("tbMail");
		Long mob = Long.parseLong(request.getParameter("tbMobile"));
		
		Customer c = new Customer(n, m, mob);
		
		CustomerDao.insertCustomer(c);

		 getCustomerListPage(request, response);
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) {
	
		try {
			RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
