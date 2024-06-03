package com.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(stepNotifications = true,
        features = {"src/test/resources/features/agregarproducto.feature"},
        tags =   "@Agregarproductos",
        glue = "com.project",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class Runner
{
}
