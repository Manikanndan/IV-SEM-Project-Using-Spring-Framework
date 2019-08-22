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
public class Report1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report1() {
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
            PdfPTable table = new PdfPTable(2);
            float[] rows = { 100f, 100f};
            table.setTotalWidth(rows);
            table.setSpacingBefore(10f);
            table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
            table.setTotalWidth(576);
            table.setLockedWidth(true);
            
    		PreparedStatement pre;
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
    	        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
    			pre = con.prepareStatement("select Orderid,Item_id,User_id,Totalprice,Qty,Orderdate,Address,Orderstat from Orderitem where User_id='"+Userid.userid+"'");
    			/*pre.setString(1, "User_id");*/
    			ResultSet rs= pre.executeQuery();
    			while(rs.next()){
    				 PdfPCell cell1 = new PdfPCell(new Paragraph("Orderid"));
    		            
    					cell1.setBorderColor(Color.BLUE);
    					cell1.setBackgroundColor(Color.LIGHT_GRAY);	
    					cell1.setPadding(5);
    					cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    					cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
    					table.addCell(cell1);
    				PdfPCell cellName = new PdfPCell(new Paragraph(rs.getString("Orderid")));
    				cellName.setBorderColor(Color.BLACK);	
    				cellName.setPadding(5);
    				cellName.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cellName.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellName);
    				PdfPCell cell2 = new PdfPCell(new Paragraph("Item_id"));
    	            cell2.setBorderColor(Color.BLUE);
    	            cell2.setBackgroundColor(Color.LIGHT_GRAY);	
    	            cell2.setPadding(5);
    	            cell2.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cell2);
    				PdfPCell cellItem_id = new PdfPCell(new Paragraph(rs.getString("Item_id")));
    				 cellItem_id.setBorderColor(Color.BLACK);	
    				 cellItem_id.setPadding(5);
    				 cellItem_id.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				 cellItem_id.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellItem_id);
    				 PdfPCell cell5 = new PdfPCell(new Paragraph("Quantity"));
    		            cell5.setBorderColor(Color.BLUE);
    		            cell5.setBackgroundColor(Color.LIGHT_GRAY);	
    		            cell5.setPadding(5);
    		            cell5.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    					cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
    					table.addCell(cell5);
    					PdfPCell cellQty = new PdfPCell(new Paragraph(rs.getString("Qty")));
    					cellQty.setBorderColor(Color.BLACK);	
    					cellQty.setPadding(5);
    					cellQty.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    					cellQty.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cellQty);
        				PdfPCell cell6 = new PdfPCell(new Paragraph("Orderdate"));
        	            cell6.setBorderColor(Color.BLUE);
        	            cell6.setBackgroundColor(Color.LIGHT_GRAY);
        	            cell6.setPadding(5);
        	            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cell6);
        				PdfPCell cellOrderdate = new PdfPCell(new Paragraph(rs.getString("Orderdate")));
        				cellOrderdate.setBorderColor(Color.BLACK);	
        				cellOrderdate.setPadding(5);
        				cellOrderdate.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cellOrderdate.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cellOrderdate);
        				PdfPCell cell7 = new PdfPCell(new Paragraph("Address"));
        	            cell7.setBackgroundColor(Color.LIGHT_GRAY);
        	            cell7.setBorderColor(Color.BLUE);
        	            cell7.setPadding(5);
        	            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cell7);
        				PdfPCell cellAddress = new PdfPCell(new Paragraph(rs.getString("Address")));
        				cellAddress.setBorderColor(Color.BLACK);	
        				cellAddress.setPadding(5);
        				cellAddress.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cellAddress.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cellAddress);
        				PdfPCell cell8 = new PdfPCell(new Paragraph("Orderstatus"));
        	            cell8.setBackgroundColor(Color.LIGHT_GRAY);
        	            cell8.setBorderColor(Color.BLUE);
        	            cell8.setPadding(5);
        	            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cell8);
        				PdfPCell cellOrderstat = new PdfPCell(new Paragraph(rs.getString("Orderstat")));
        				cellOrderstat.setBorderColor(Color.BLACK);	
        				cellOrderstat.setPadding(5);
        				cellOrderstat.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cellOrderstat.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cellOrderstat);
        				PdfPCell cell4 = new PdfPCell(new Paragraph("Totalprice"));
        	            cell4.setBorderColor(Color.BLUE);
        	            cell4.setBackgroundColor(Color.LIGHT_GRAY);		
        	            cell4.setPadding(5);
        	            cell4.setVerticalAlignment(Element.ALIGN_MIDDLE	);
        				cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        				table.addCell(cell4);
    				PdfPCell cellTotalprice = new PdfPCell(new Paragraph(rs.getString("Totalprice")));
    				cellTotalprice.setBorderColor(Color.BLACK);	
    				cellTotalprice.setPadding(5);
    				cellTotalprice.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cellTotalprice.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellTotalprice);
    				
    				
    				
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
