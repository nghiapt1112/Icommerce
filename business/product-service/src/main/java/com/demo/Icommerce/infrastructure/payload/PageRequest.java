package com.demo.Icommerce.infrastructure.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public abstract class PageRequest extends BaseObject {
    protected Long id;
    protected Integer page;
    protected Integer size;
    protected StringBuilder queryCondition;
    protected Map<String, Object> queryParams;


    public void setPage(Integer page) {
        if (page == null || page <= 0) {
            this.page = 0;
        } else {
            this.page = page - 1;
        }
    }

    public org.springframework.data.domain.PageRequest toPageRequest() {
        return org.springframework.data.domain.PageRequest.of(page, size);
    }

    @JsonIgnore
    public int getFirstResult() {
        if (Objects.isNull(this.page)) {
            this.page = 1;
        }
        if (Objects.isNull(this.size)) {
            this.size = 100;
        }
        return this.page * this.size;
    }

    public abstract void parseQuery();
}
