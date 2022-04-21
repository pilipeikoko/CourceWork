package com.bsuir.classdiagram.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JavaCustomStructure extends CustomStructure {
    private CustomPackage customPackage;
    private List<CustomImport> customImports;
    private List<CustomClass> customClasses;

    public void updatePackageName(String packageName) {
        if (Objects.nonNull(packageName)) {
            this.customPackage = CustomPackage.of(
                packageName.substring(packageName.indexOf(" "), packageName.length() - 1).trim()
            );
        }
    }

    public void addImport(String text) {
        if (Objects.isNull(customImports)) {
            this.customImports = new ArrayList<>();
        }
        this.customImports.add(CustomImport.of(
            text.substring(text.indexOf(" "), text.length() - 1).trim()
        ));
    }

    public void addKlass(List<CustomModifier> customModifiers, String type, String className, List<CustomType> customTypes) {
        if (Objects.isNull(customClasses)) {
            this.customClasses = new ArrayList<>();
        }
        this.customClasses.add(
            new CustomClass(customModifiers, type, className, customTypes)
        );
    }

    public CustomClass getCustomClass() {
        if (Objects.isNull(customClasses) || customClasses.isEmpty()) {

        }
        return this.customClasses.get(customClasses.size() - 1);
    }

    public List<CustomClass> getCustomClasses() {
        return customClasses;
    }

    public CustomPackage getCustomPackage() {
        return customPackage;
    }

    public List<CustomImport> getImports() {
        return customImports;
    }
}
