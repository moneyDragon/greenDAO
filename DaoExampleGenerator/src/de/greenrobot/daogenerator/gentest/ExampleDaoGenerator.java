/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import java.util.List;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Index;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class ExampleDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1, "de.greenrobot.daoexample");
        schema.enableKeepSectionsByDefault();

        addNote(schema);
        addCustomerOrder(schema);

        // 模拟生成搜狐视频相关表
        addLocalMedia(schema);
        addLocalPlayHistory(schema);
        addAmericanNeighbour(schema);
        addApkDownload(schema);
        addPlayHistory(schema);

        new DaoGenerator().generateAll(schema, "../DaoExample/src-gen");
    }

    private static void addNote(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }

    private static void addCustomerOrder(Schema schema) {
        Entity customer = schema.addEntity("Customer");
        customer.addIdProperty();
        customer.addStringProperty("name").notNull();

        Entity order = schema.addEntity("Order");
        order.setTableName("ORDERS"); // "ORDER" is a reserved keyword
        order.addIdProperty();
        Property orderDate = order.addDateProperty("date").getProperty();
        Property customerId = order.addLongProperty("customerId").notNull().getProperty();
        order.addToOne(customer, customerId);

        ToMany customerToOrders = customer.addToMany(order, customerId);
        customerToOrders.setName("orders");
        customerToOrders.orderAsc(orderDate);
    }

    private static void addLocalMedia(Schema schema) {
        Entity localMedia = schema.addEntity("LocalMedia");

        localMedia.addIdProperty();
        localMedia.addStringProperty("dir");
        localMedia.addStringProperty("file");
        localMedia.addIntProperty("size");
    }

    private static void addLocalPlayHistory(Schema schema) {
        Entity lp = schema.addEntity("LocalPlayHistory");
        lp.addIdProperty();
        lp.addStringProperty("videoTitle");
        lp.addStringProperty("playedTime");
        lp.addIntProperty("tvLength");
        lp.addStringProperty("lastWatchTime");
        lp.addStringProperty("localUrl");
    }

    private static void addAmericanNeighbour(Schema schema) {
        Entity neighBour = schema.addEntity("AmericanNeighbour");
        neighBour.addIdProperty();
        neighBour.addIntProperty("channel_id");
        neighBour.addStringProperty("request_url");
        neighBour.addStringProperty("reponse");
        neighBour.addIntProperty("list_index");
        neighBour.addIntProperty("update_time");
        neighBour.addIntProperty("operation_type");
    }

    private static void addApkDownload(Schema schema) {
        Entity down = schema.addEntity("ApkDownload");
        down.addStringProperty("package_name");
        down.addIntProperty("version");
        down.addStringProperty("tip");
        down.addStringProperty("name");
        down.addIntProperty("downing_state");
        down.addIntProperty("total_filesize");
        down.addIntProperty("download_beginning");
        down.addIntProperty("downloaded_size");
        down.addIntProperty("download_percent");
        down.addIntProperty("create_time");
        down.addStringProperty("download_url");
        down.addStringProperty("save_dir");
        down.addStringProperty("save_name");
    }

    private static void addPlayHistory(Schema schema) {
        Entity his = schema.addEntity("PlayHistory");

        his.addIdProperty().autoincrement();

        his.addStringProperty("playId");
        his.addStringProperty("subjectId");
        his.addStringProperty("videoTitle");
        his.addStringProperty("playedTime");
        his.addStringProperty("clientType");
        his.addStringProperty("definition");
        his.addStringProperty("episode");
        his.addStringProperty("picPath");
        his.addStringProperty("categoryId");
        his.addIntProperty("tvLength");
        his.addIntProperty("isSynchronized");
        his.addStringProperty("albumName");
        his.addIntProperty("nextplayId");
        his.addStringProperty("lastWatchTime");
        his.addStringProperty("passport");
        his.addStringProperty("localUrl");
        his.addIntProperty("tvisfee");
        his.addIntProperty("real_playorder");
        his.addIntProperty("site");

        List<Property> pros = his.getProperties();
        if (pros != null && pros.size() > 0) {
            for (Property p : pros) {
                if ("playId".equals(p.getPropertyName())) {
                    Index index = new Index();
                    index.addProperty(p);
                    his.addIndex(index);
                    break;
                }
            }
        }
    }

}
