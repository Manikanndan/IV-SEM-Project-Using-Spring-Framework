package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Userid;

import com.bean.UserBean;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class Report
 */
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OutputStream out=response.getOutputStream();
        try {
        	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            String dt=formatter.format(date);
            Document document = new Document();
            /* Basic PDF Creation inside servlet */
            PdfWriter.getInstance(document, out);
            document.open();
            document.addAuthor("Mani");
            
            Paragraph paragraph = new Paragraph("'Cosmos Medical Equipment'");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph=new Paragraph("Kristu Jayanti College Autonomous- K Narayanapura Bengaluru");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph=new Paragraph("Bengaluru-560077");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);
            paragraph=new Paragraph("Companies Product Report");
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.setSpacingBefore(20);
            paragraph.setSpacingAfter(20);
            document.add(paragraph);
            paragraph=new Paragraph("Date: "+dt);
            paragraph.setAlignment(Element.ALIGN_RIGHT);
            paragraph.setSpacingAfter(10);
            document.add(paragraph);
            
            
            /*document.add(new Paragraph("Team name"));*/
            PdfPTable table = new PdfPTable(8);
            float[] rows = { 100f, 100f, 100f, 100f, 100f, 100f,100f,100f};
            table.setTotalWidth(rows);
            table.setSpacingBefore(10f);
            table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
            table.setTotalWidth(576);
            table.setLockedWidth(true);
            
              
            PdfPCell cell1 = new PdfPCell(new Paragraph("UserID"));
            
			cell1.setBorderColor(Color.BLUE);
			cell1.setBackgroundColor(Color.LIGHT_GRAY);	
			cell1.setPadding(5);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

            
           
            PdfPCell cell2 = new PdfPCell(new Paragraph("FirstName"));
            cell2.setBorderColor(Color.BLUE);
            cell2.setBackgroundColor(Color.LIGHT_GRAY);	
            cell2.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
            PdfPCell cell3 = new PdfPCell(new Paragraph("LastName"));
            cell3.setBorderColor(Color.BLUE);
            cell3.setBackgroundColor(Color.LIGHT_GRAY);
           cell3.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			
            
            PdfPCell cell4 = new PdfPCell(new Paragraph("Username"));
            cell4.setBorderColor(Color.BLUE);
            cell4.setBackgroundColor(Color.LIGHT_GRAY);		
            cell4.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell5 = new PdfPCell(new Paragraph("EmailAddress"));
            cell5.setBorderColor(Color.BLUE);
            cell5.setBackgroundColor(Color.LIGHT_GRAY);	
            cell5.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell6 = new PdfPCell(new Paragraph("Phonenumber"));
            cell6.setBorderColor(Color.BLUE);
            cell6.setBackgroundColor(Color.LIGHT_GRAY);
            cell6.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell7 = new PdfPCell(new Paragraph("Gender"));
            cell7.setBackgroundColor(Color.LIGHT_GRAY);
            cell7.setBorderColor(Color.BLUE);
            cell7.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
			PdfPCell cell8 = new PdfPCell(new Paragraph("Address"));
            cell8.setBackgroundColor(Color.LIGHT_GRAY);
            cell8.setBorderColor(Color.BLUE);
            cell8.setPadding(5);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
			table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            table.addCell(cell8);
            
           
    		PreparedStatement pre;
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
    			pre = con.prepareStatement("select * from Register where Username <> 'admin'");
    			/*pre.setString(1, "User_id");*/
    			ResultSet rs= pre.executeQuery();
    			while(rs.next()){
    				PdfPCell cellName = new PdfPCell(new Paragraph(rs.getString("User_id")));
    				table.addCell(cellName);
    				PdfPCell cellItem_id = new PdfPCell(new Paragraph(rs.getString("Firstname")));
    				table.addCell(cellItem_id);
    				PdfPCell cellUser_id = new PdfPCell(new Paragraph(rs.getString("Lastname")));
    				table.addCell(cellUser_id);
    				PdfPCell cellTotalprice = new PdfPCell(new Paragraph(rs.getString("Username")));
    				table.addCell(cellTotalprice);
    				PdfPCell cellQty = new PdfPCell(new Paragraph(rs.getString("EmailAddress")));
    				table.addCell(cellQty);
    				PdfPCell cellOrderdate = new PdfPCell(new Paragraph(rs.getString("Phonenumber")));
    				table.addCell(cellOrderdate);
    				PdfPCell cellAddress = new PdfPCell(new Paragraph(rs.getString("Gender")));
    				table.addCell(cellAddress);
    				PdfPCell cellOrderstat = new PdfPCell(new Paragraph(rs.getString("Address")));
    				table.addCell(cellOrderstat);
    				
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		
            // Adding cells to the table       
               
            // Adding Table to document        
            document.add(table);                  
            
            document.close();
        }
                catch (DocumentException exc){
                throw new IOException(exc.getMessage());
                }
        finally {            
            out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
