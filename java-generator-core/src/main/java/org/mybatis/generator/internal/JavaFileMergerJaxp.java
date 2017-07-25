package org.mybatis.generator.internal;

import org.mybatis.generator.api.GeneratedJavaFile;
import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.exception.ShellException;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.xml.sax.InputSource;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;



/**
 * Created by whm on 2017/7/24.
 */
public class JavaFileMergerJaxp {
    public static void getMergedSource(GeneratedJavaFile generatedXmlFile,
                                       File existingFile) throws ShellException {
        BufferedReader bs  = null;
        try {
            bs = new BufferedReader(new FileReader(existingFile));
            String line = null;
            String regEx = "";
            while((line = bs.readLine()) != null){
//                System.out.println(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
