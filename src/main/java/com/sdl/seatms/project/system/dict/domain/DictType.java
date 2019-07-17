package com.sdl.seatms.project.system.dict.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.sdl.seatms.framework.aspectj.lang.annotation.Excel;
import com.sdl.seatms.framework.web.domain.BaseEntity;

/**
 * 字典类型对象 sys_dict_type
 * 
 * @author sdl
 */
@Data
public class DictType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 字典主键 */
    @Excel(name = "字典主键")
    private Long dictId;

    /** 字典名称 */
    @Excel(name = "字典名称")
    private String dictName;

    /** 字典类型 */
    @Excel(name = "字典类型 ")
    private String dictType;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;
}
