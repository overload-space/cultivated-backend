package com.cultivated.app.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
    /**
     * @param pagingList data
     * @param pageNum    if pageNum <= 0, return everything
     * @param pageSize   if pageSize <= 0, return everything
     * @return page
     */
    public static <E> Page<E> getPage(List<E> pagingList, int pageNum, int pageSize) {
        if (pagingList == null) {
            throw new IllegalArgumentException("Paging list can not be null");
        }

        Page<E> page = new Page<>();
        if (pageNum <= 0 || pageSize <= 0) {
            Pagination pagination = new Pagination();
            pagination.setTotal(pagingList.size());
            pagination.setPage(0);
            pagination.setSize(0);

            page.setPagination(pagination);
            page.setData(pagingList);
        } else {
            Pagination pagination = new Pagination();
            pagination.setTotal(pagingList.size());
            pagination.setPage(pageNum);
            pagination.setSize(pageSize);

            page.setPagination(pagination);
            page.setData(subList(pagingList, pageNum, pageSize));
        }

        return page;
    }

    private static <E> List<E> subList(List<E> list, int pageNum, int pageSize) {
        int size = list.size();

        List<E> result = new ArrayList<>();
        int idx = (pageNum - 1) * pageSize;
        int end = idx + pageSize;
        while (idx < size && idx < end) {
            result.add(list.get(idx));
            idx++;
        }

        return result;
    }
}
