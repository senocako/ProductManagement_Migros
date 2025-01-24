package com.migros.product_app.model.service;

import java.util.List;

public interface EntityService<E, I>
{

    void deleteById(I id);

    E findById(I id);

    List<E> getAll();

    E insert(E entity);
}
