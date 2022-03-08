package de.jk.fm.ext.output;


import freemarker.core.Environment;
import freemarker.template.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * It's an extension for usage in Freemarker Templates.
 * You can delegate apart from main output file temporarily to different  files as shown in the
 * example Freemarker template file (*.ftl) below:
 *
 * <pre>
 * &lt;&#35;assign output = "de.jk.fm.ext.output.OutputDirective"?new()&gt;
 * ...
 * content of main output file
 * ...
 * &lt;&#64;output file="./file1.txt"&gt;
 * ...
 * content of file1.txt
 * ...
 * &lt;/&#64;output&gt;
 * ...
 * content of main output file
 * </pre>
 *
 * @author Juegen Kuerpig
 */
public class OutputDirective implements TemplateDirectiveModel {

    @Override
    public void execute(
            Environment env,
            @SuppressWarnings("rawtypes") Map params,
            TemplateModel[] loopVars,
            TemplateDirectiveBody body)
            throws TemplateException, IOException {

        SimpleScalar file = (SimpleScalar) params.get("file");

        FileWriter fw = new FileWriter(new File(file.getAsString()));
        body.render(fw);
        fw.flush();
    }
}
