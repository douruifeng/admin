package wcaa.Vo;

import java.util.List;

public class PageResult {

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getItems() {
        return items;
    }

    public void setItems(List items) {
        this.items = items;
    }

    private Integer total=0;
    private List items;
}
