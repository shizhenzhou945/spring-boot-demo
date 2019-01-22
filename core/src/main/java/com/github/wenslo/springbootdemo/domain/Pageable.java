package com.github.wenslo.springbootdemo.domain;

import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/**
 * @author wenhailin
 * @version 0.0.1
 * @createTime 2018年12月02日 下午2:55
 * @description 自定义分页
 */
public class Pageable implements org.springframework.data.domain.Pageable, Serializable {
    private boolean paged = true;
    private boolean unpaged = false;
    private Integer page;
    private Integer size;
    private Sort sort;
    private Sort sortOr;


    @Override
    public boolean isPaged() {
        return paged;
    }

    @Override
    public boolean isUnpaged() {
        return unpaged;
    }

    @Override
    public int getPageNumber() {
        return Objects.isNull(page) ? 0 : page;
    }

    @Override
    public int getPageSize() {
        return Objects.isNull(size) ? 20 : size;
    }

    @Override
    public long getOffset() {
        return (long) page * (long) size;
    }

    @Override
    public Sort getSort() {
        return Objects.isNull(sort) ? Sort.by("id") : sort;
    }

    @Override
    public Sort getSortOr(Sort sort) {
        return Objects.isNull(sortOr) ? Sort.by("id") : sortOr;
    }

    public Pageable() {
    }

    public Pageable(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public Pageable(Integer page, Integer size, Sort sort) {
        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    @Override
    public org.springframework.data.domain.Pageable next() {
        return new Pageable(getPageNumber() + 1, getPageSize(), getSort());
    }

    public Pageable previous() {
        return getPageNumber() == 0 ? this : new Pageable(getPageNumber() - 1, getPageSize(), getSort());
    }

    @Override
    public org.springframework.data.domain.Pageable first() {
        return new Pageable(0, getPageSize(), getSort());
    }

    @Override
    public org.springframework.data.domain.Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    @Override
    public boolean hasPrevious() {
        return page > 0;
    }

    @Override
    public Optional<org.springframework.data.domain.Pageable> toOptional() {
        return isUnpaged() ? Optional.empty() : Optional.of(this);
    }

    public void setPaged(boolean paged) {
        this.paged = paged;
    }

    public void setUnpaged(boolean unpaged) {
        this.unpaged = unpaged;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public Sort getSortOr() {
        return sortOr;
    }

    public void setSortOr(Sort sortOr) {
        this.sortOr = sortOr;
    }


}
