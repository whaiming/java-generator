package org.mybatis.generator.internal;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.exception.ShellException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by whm on 2017/7/24.
 */
public class JavaFileMergerJaxp {
    public static String mergeJavaFile(String newFileSource,
                                String existingFileFullPath, String fileEncoding)
            throws ShellException, FileNotFoundException {
        return getNewJavaFile(newFileSource,existingFileFullPath);
//        List<String> commentedNodeList = getCommentedNodeList(existingFileFullPath);
//        if (commentedNodeList.size()>0) {
//            StringBuffer sb = new StringBuffer(newFileSource.substring(0, newFileSource.lastIndexOf("}")));
//            for (String str : commentedNodeList) {
//                sb.append("     "+str+System.getProperty("line.separator"));
//            }
//            return sb.append(System.getProperty("line.separator")+"}").toString();
//        }else {
//            return newFileSource;
//        }

    }
    public static String getNewJavaFile(String newFileSource, String existingFileFullPath) throws FileNotFoundException {

        CompilationUnit newCompilationUnit = JavaParser.parse(newFileSource);
        StringBuffer sb = new StringBuffer(newCompilationUnit.getPackageDeclaration().get().toString());
        newCompilationUnit.removePackageDeclaration();

        //合并imports
        CompilationUnit existingCompilationUnit = JavaParser.parse(new File(existingFileFullPath));
        NodeList<ImportDeclaration> imports = newCompilationUnit.getImports();
        imports.addAll(existingCompilationUnit.getImports());
        Set importSet = new HashSet<ImportDeclaration>();
        importSet.addAll(imports);

//        importSet.forEach(System.out::println);
        NodeList<ImportDeclaration> newImports = new NodeList<>();
        newImports.addAll(importSet);
        newCompilationUnit.setImports(newImports);
        for (ImportDeclaration i:newCompilationUnit.getImports()) {
            sb.append(i.toString());
        }

        NodeList<TypeDeclaration<?>> types = newCompilationUnit.getTypes();
        NodeList<TypeDeclaration<?>> oldTypes = existingCompilationUnit.getTypes();

        for (int i = 0;i<types.size();i++) {
            //截取Class
            String classNameInfo = types.get(i).toString().substring(0, types.get(i).toString().indexOf("{")+1);
            sb.append(classNameInfo);
            //合并fields
            List<FieldDeclaration> fields = types.get(i).getFields();
            List<FieldDeclaration> oldFields = oldTypes.get(i).getFields();
            List<FieldDeclaration> newFields = new ArrayList<>();
            HashSet<FieldDeclaration> fieldDeclarations = new HashSet<>();
            fieldDeclarations.addAll(fields);
            fieldDeclarations.addAll(oldFields);
            newFields.addAll(fieldDeclarations);
            for (FieldDeclaration f: newFields){
                sb.append(f.toString());
            }


            //合并methods
            List<MethodDeclaration> methods = types.get(i).getMethods();
            List<MethodDeclaration> existingMethods = oldTypes.get(i).getMethods();
            for (MethodDeclaration f: methods){
                sb.append(f.toString());
            }
            for (MethodDeclaration m:existingMethods){
                boolean flag = true;
                for (String tag : MergeConstants.OLD_ELEMENT_TAGS) {
                    if (m.toString().contains(tag)) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    sb.append(m.toString());
                }
            }

            //判断是否有内部类
            types.get(i).getChildNodes();
            for (Node n:types.get(i).getChildNodes()){
                if (n.toString().contains("class")){
                    sb.append(n.toString());
                }
            }

        }

        return sb.append("}").toString();
    }
}
