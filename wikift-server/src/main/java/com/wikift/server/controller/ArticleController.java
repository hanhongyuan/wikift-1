/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wikift.server.controller;

import com.wikift.common.enums.MessageEnums;
import com.wikift.model.article.ArticleEntity;
import com.wikift.model.result.CommonResult;
import com.wikift.support.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    CommonResult<ArticleEntity> save(@RequestBody ArticleEntity entity) {
        Assert.notNull(entity, MessageEnums.PARAMS_NOT_NULL.getValue());
        entity.setId(0l);
        return CommonResult.success(articleService.save(entity));
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    CommonResult<ArticleEntity> update(@RequestBody ArticleEntity entity) {
        Assert.notNull(entity, MessageEnums.PARAMS_NOT_NULL.getValue());
        return CommonResult.success(articleService.update(entity));
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    CommonResult<ArticleEntity> delete(@PathVariable(value = "id") Long id) {
        Assert.notNull(id, MessageEnums.PARAMS_NOT_NULL.getValue());
        return CommonResult.success(articleService.delete(id));
    }

    @RequestMapping(value = "info/{id}", method = RequestMethod.GET)
    CommonResult<ArticleEntity> info(@PathVariable(value = "id") Long id) {
        Assert.notNull(id, MessageEnums.PARAMS_NOT_NULL.getValue());
        return CommonResult.success(articleService.info(id));
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    CommonResult<ArticleEntity> list() {
        return CommonResult.success(articleService.findAll());
    }

}