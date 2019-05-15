
package com.crypterium.cryptApi.pojos.catalogs;

import com.google.gson.annotations.Expose;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class CatalogCurrency {

    @Expose
    private String code;
    @Expose
    private Long scale;
    @Expose
    private String template;

    public String getCode() {
        return code;
    }

    public CatalogCurrency setCode(String code) {
        this.code = code;
        return this;
    }

    public Long getScale() {
        return scale;
    }

    public CatalogCurrency setScale(Long scale) {
        this.scale = scale;
        return this;
    }

    public String getTemplate() {
        return template;
    }

    public CatalogCurrency setTemplate(String template) {
        this.template = template;
        return this;
    }
}
