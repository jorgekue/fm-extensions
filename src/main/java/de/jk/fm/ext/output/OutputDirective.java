package de.jk.fm.ext.output;


import freemarker.core.Environment;
import freemarker.template.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

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
