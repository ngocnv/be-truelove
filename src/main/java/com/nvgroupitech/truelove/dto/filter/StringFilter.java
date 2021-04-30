package com.nvgroupitech.truelove.dto.filter;

import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
/**
 * Class for filtering attributes with {@link String} type.
 * It can be added to a criteria class as a member, to support the following query parameters:
 * <code>
 * fieldName.equals='something'
 * fieldName.specified=true
 * fieldName.specified=false
 * fieldName.in='something','other'
 * fieldName.contains='thing'
 * </code>
 */
public class StringFilter extends Filter<String> implements Converter<String, StringFilter> {

    private static final long serialVersionUID = 1L;

    private String contains;
    private String likeType;//'left','right',default is 'all'

    public StringFilter() {
    }

    public StringFilter(String contains) {
        this.contains = contains;
    }

    public StringFilter(String contains, String likeType) {
        this.contains = contains;
        this.likeType = likeType;
    }

    public String getContains() {
        return contains;
    }

    public StringFilter setContains(String contains) {
        this.contains = contains;
        return this;
    }

    public String getLikeType() {
        return likeType;
    }

    public StringFilter setLikeType(String type) {
        this.likeType = type;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final StringFilter that = (StringFilter) o;
        return Objects.equals(contains, that.contains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contains);
    }

    @Override
    public String toString() {
        return getFilterName() + " ["
                + (getContains() != null ? "contains=" + getContains() + ", " : "")
                + (getEquals() != null ? "equals=" + getEquals() + ", " : "")
                + (getSpecified() != null ? "specified=" + getSpecified() : "")
                + (getLikeType() != null ? "likeType=" + getLikeType() : "")
                + "]";
    }

   
    public StringFilter convert(String s) {
        return new StringFilter(s);
    }
}