package fpt.edu.vn.tingstoreapp.models.specs;

import java.util.List;

public class Pagination<T> {
    private int pageIndex;
    private int pageSize;
    private long count;
    private List<T> data;
    public Pagination(){}
    public Pagination(int pageIndex, int pageSize, long count, List<T> data) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.count = count;
        this.data = data;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
