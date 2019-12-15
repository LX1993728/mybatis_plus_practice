package com.liuxun.domain.po;

import com.liuxun.domain.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liuxun
 */

@Data
@ApiModel
public class UserBookItem {
    @ApiModelProperty(name = "userId" , value = "ID" )
    private Long userId;

    @ApiModelProperty(name = "nickname" , value = "昵称")
    private String nickname;

    @ApiModelProperty(name = "bookId" , value = "")
    private Long bookId;

    @ApiModelProperty(name = "bookName" , value = "书名")
    private String bookName;

    @ApiModelProperty(name = "author" , value = "作者")
    private String author;

}
