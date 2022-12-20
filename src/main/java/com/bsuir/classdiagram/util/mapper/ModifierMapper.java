package com.bsuir.classdiagram.util.mapper;

import com.bsuir.classdiagram.model.TypeModifier;

public abstract class ModifierMapper {
    public abstract TypeModifier Map(String value);
    public abstract String Map(TypeModifier modifier);
}
