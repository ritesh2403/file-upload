package Controller;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import Entity.Customer;
import Excel.ExcelDocument;
import Service.CustomerServiceImp;

@Component
@RequestMapping("customer")
public class CustomerController {
	private static final String ABS_PATH="D:\\ghora\\eclipse-workspace\\springmvc\\src\\main\\webapp\\WEB-INF\\images"; 
	private static  String REAL_PATH="";
	@Autowired
	private CustomerServiceImp service;

	@Autowired
	ServletContext context;

	@RequestMapping(value="/file",method=RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mv = new ModelAndView("fileupload");
		return mv;
		
	}
	
	@RequestMapping(value="/fileupload",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> fileUpload(MultipartHttpServletRequest request,HttpServletResponse response){
	System.out.println("in fileupload");
	REAL_PATH=request.getSession().getServletContext().getRealPath("/WEB-INF/images");
	System.out.println("REAL_PATH");	
	List<String>list=new ArrayList<String>();
		Map<String,Object>map=new HashMap<String,Object>();
		Iterator<String> itr=request.getFileNames();
		MultipartFile mpf=null;
		
		//to make sure all directories exist please create
		if(!new File(ABS_PATH).exists()) {
			//create directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists()) {
			//create directories
			new File(REAL_PATH).mkdirs();
		}
		while(itr.hasNext()) {
			mpf=request.getFile(itr.next());
			
			  try { // FileCopyUtils.copy(context.getRealPath("resources")+ "/"+ mpf.getBytes(),new FileOutputStream(mpf.getOriginalFilename().replace(" ","-")));
	
				  FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(REAL_PATH+"/"+mpf.getOriginalFilename().replace(" ","-")));
				  list.add(mpf.getOriginalFilename().replace(" ", "-"));
			  
			  }
			  catch(IOException e) { e.printStackTrace(); }
			 
		}
		map.put("status", 200);
		map.put("uploadedfile", list);
		return map;
		
	}
	
	
	@RequestMapping("/list")
	public ModelAndView listCustomers(Model themodel,HttpServletRequest request,HttpServletResponse response) {
		String x="invalid format of file";
		ModelAndView mv = new ModelAndView();
		String type=request.getParameter("type");
		Customer c = new Customer();
		List<Customer> customer = service.customers();
		if(type!=null && type.equalsIgnoreCase("xls")) {
			return new ModelAndView(new ExcelDocument(),"customers",customer);
		}
		
		c.setCustomers(customer);
		mv.addObject("customers", customer);
		mv.setViewName("displayCustomer");

		return mv;

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(@RequestParam("customerId") int id) {
		ModelAndView mv = new ModelAndView();
		Customer c = new Customer();
		Customer customer = service.getCustomer(id);
		mv.addObject("Customers", customer);
		mv.setViewName("AddCustomer");
		return mv;

	}

	@RequestMapping(value = "/creditcard", method = RequestMethod.POST)
	public ModelAndView updateCustomer(@RequestBody Customer customer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("Customers", customer);
		mv.setViewName("edit");
		return mv;

	}

}
