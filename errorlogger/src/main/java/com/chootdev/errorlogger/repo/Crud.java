package com.chootdev.errorlogger.repo;

import java.util.List;

public interface Crud {
    int create(Object item);
    int delete(Object item);
    Object findById(int id);
    List<?> findAll();
}
