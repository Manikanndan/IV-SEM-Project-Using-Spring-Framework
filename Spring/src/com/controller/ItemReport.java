 package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;

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

import com.bean.UserBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Servlet implementation class Report
 */
public class ItemReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemReport() {
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
            document.addAuthor("pavan");
            
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
           
            document.setPageSize(PageSize.A4);
            
            PdfPTable table = new PdfPTable(7);
            float[] rows = { 100f, 100f, 100f, 100f, 100f, 100f,100f };
            table.setTotalWidth(rows);
            table.setSpacingBefore(10f);
            table.setHorizontalAlignment(Element.ALIGN_JUSTIFIED_ALL);
            table.setTotalWidth(576);
            table.setLockedWidth(true);
           
            
            PdfPCell cell1 = new PdfPCell(new Paragraph("Product ID"));
            
			cell1.setBorderColor(Color.BLUE);
			cell1.setBackgroundColor(Color.LIGHT_GRAY);	
			cell1.setPadding(5);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

            
           
            PdfPCell cell2 = new PdfPCell(new Paragraph("Product Name"));
            cell2.setBorderColor(Color.BLUE);
            cell2.setBackgroundColor(Color.LIGHT_GRAY);	
            cell2.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			
            PdfPCell cell3 = new PdfPCell(new Paragraph("Price"));
            cell3.setBorderColor(Color.BLUE);
            cell3.setBackgroundColor(Color.LIGHT_GRAY);
           cell3.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			
            
            PdfPCell cell4 = new PdfPCell(new Paragraph("Quantity"));
            cell4.setBorderColor(Color.BLUE);
            cell4.setBackgroundColor(Color.LIGHT_GRAY);		
            cell4.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell5 = new PdfPCell(new Paragraph("Vendor"));
            cell5.setBorderColor(Color.BLUE);
            cell5.setBackgroundColor(Color.LIGHT_GRAY);	
            cell5.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell6 = new PdfPCell(new Paragraph("Category"));
            cell6.setBorderColor(Color.BLUE);
            cell6.setBackgroundColor(Color.LIGHT_GRAY);
            cell6.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            PdfPCell cell7 = new PdfPCell(new Paragraph("Offer"));
            cell7.setBackgroundColor(Color.LIGHT_GRAY);
            cell7.setBorderColor(Color.BLUE);
            cell7.setPadding(5);
            cell1.setVerticalAlignment(Element.ALIGN_MIDDLE	);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);	
            
			table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);
            
            
            
    		try {
    			Class.forName("com.mysql.jdbc.Driver");
        		Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
        		PreparedStatement pre;
    			pre = con1.prepareStatement("select Item_id,itemname,itemprice,itemvendor,itemoffer,itemcategory,itemqty from Additem");
    			ResultSet rs= pre.executeQuery();
    			while(rs.next()){
    				PdfPCell cellName = new PdfPCell(new Paragraph(rs.getString("Item_id")));
    				cellName.setBorderColor(Color.BLACK);	
    				cellName.setPadding(5);
    				cellName.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cellName.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellName);
    				PdfPCell cellId = new PdfPCell(new Paragraph(rs.getString("itemname")));
    				cellId.setBorderColor(Color.BLACK);	
    				cellId.setPadding(5);
    				cellId.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cellId.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellId);
    				PdfPCell cellEmail = new PdfPCell(new Paragraph(rs.getString("itemprice")));
    				cellEmail.setBorderColor(Color.BLACK);	
    				cellEmail.setPadding(5);
    				cellEmail.setVerticalAlignment(Element.ALIGN_MIDDLE	);
    				cellEmail.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellEmail);
    				PdfPCell cellqty = new PdfPCell(new Paragraph(rs.getString("itemqty")));
    				cellqty.setBorderColor(Color.BLACK);	
    				cellqty.setPadding(5);
    				cellqty.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cellqty.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellqty);
    				PdfPCell cellqven= new PdfPCell(new Paragraph(rs.getString("itemvendor")));
    				cellqven.setBorderColor(Color.BLACK);	
    				cellqven.setPadding(5);
    				cellqven.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cellqven.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellqven);
    				PdfPCell cellcat= new PdfPCell(new Paragraph(rs.getString("itemcategory")));
    				cellcat.setBorderColor(Color.BLACK);	
    				cellcat.setPadding(5);
    				cellcat.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				cellcat.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(cellcat);
    				PdfPCell celloff= new PdfPCell(new Paragraph(rs.getString("itemoffer")));
    				celloff.setBorderColor(Color.BLACK);	
    				celloff.setPadding(5);
    				celloff.setVerticalAlignment(Element.ALIGN_MIDDLE);
    				celloff.setHorizontalAlignment(Element.ALIGN_CENTER);
    				table.addCell(celloff);
    				
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
