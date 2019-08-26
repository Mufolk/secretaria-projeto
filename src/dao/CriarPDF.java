/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author RafaelSStavale
 */

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import model.entity.Aluno;
import model.requerimento.Requerimento;

public class CriarPDF {
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
   private static  Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    public CriarPDF(Requerimento requerimento){
    String FILE = "../Relatorios/" + requerimento.getNumeroRequerimento() +".pdf";
     try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document, requerimento);
            addContent(document, requerimento);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   


    // iText allows to add metadata to the PDF which can be viewed in your Adobe
    // Reader
    // under File -> Properties
    private static void addMetaData(Document document, Requerimento requerimento) {
        document.addTitle(requerimento.getNumeroRequerimento());
        
    }

    private static void addContent(Document document, Requerimento requerimento) throws BadElementException, IOException, DocumentException {
        
        String imagemEndereco = "src/images/LOGO-UNIRIO.png";
        Image img = Image.getInstance(imagemEndereco);
        img.setAlignment(Element.ALIGN_CENTER);
        
        img.scaleToFit(600,600);
                
        Aluno aluno = (Aluno) requerimento.getRequerente();
        Anchor anchor = new Anchor("Protocolo:" + requerimento.getNumeroRequerimento() + " - " + requerimento.getStatus(), catFont);
        anchor.setName("Protocolo:" + requerimento.getNumeroRequerimento()+ " - " + requerimento.getStatus());

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
           
        Paragraph subPara = new Paragraph("Requerente", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Nome do Requerente: " +aluno.getNome()));
        subCatPart.add(new Paragraph("Nome do Requerente: " + aluno.getEmail()));
        subCatPart.add(new Paragraph("Número de matrícula: " + aluno.getMatricula()));
        subCatPart.add(new Paragraph("Número de Telefone: " + aluno.getTelefoneCelular()));
        subCatPart.add(new Paragraph("Periodo: " + aluno.getPeriodo()));
        
        
        subPara = new Paragraph("Requerimento", subFont);
        subCatPart = catPart.addSection(subPara);
        if(requerimento.getTipoRequerimento().equals("Realização de segunda chamada")
            || requerimento.getTipoRequerimento().equals("Revisão de prova")
            || requerimento.getTipoRequerimento().equals("Isenção ou aproveitamento de disciplina")){
            subCatPart.add(new Paragraph("Tipo de requerimento: " + requerimento.getTipoRequerimento()));
            subCatPart.add(new Paragraph("Disciplina: " + requerimento.getDisciplina()));
            subCatPart.add(new Paragraph("\n Descrição: \n" +  requerimento.getDescricao()));
            subCatPart.add(new Paragraph("\n Resposta: \n" +  requerimento.getResposta()));
        }
        else{
            subCatPart.add(new Paragraph("Tipo de requerimento: " + requerimento.getTipoRequerimento()));
            subCatPart.add(new Paragraph("\n Descrição: \n" +  requerimento.getDescricao()));
            subCatPart.add(new Paragraph("\n Resposta: \n" +  requerimento.getResposta()));
        }

    
    
        // now add all this to the document
   
        document.add(img);
        document.add(catPart);

          }
    
  }