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

    public static void main(String[] args) {
        generateDbV2();
    }
    
    private static void generateDbV1() {
        Schema schema = new Schema(1, "de.greenrobot.daoexample");
        schema.enableKeepSectionsByDefault();

        addNoteV1(schema);
        addCustomerOrderV1(schema);
        addLocalMediaV1(schema);
        addLocalPlayHistoryV1(schema);
        addAmericanNeighbourV1(schema);
        addPlayHistoryV1(schema);
        
        try {
            new DaoGenerator().generateAll(schema, "../DaoExample/src-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void generateDbV2() {
        Schema schema = new Schema(2, "de.greenrobot.daoexample");
        schema.enableKeepSectionsByDefault();

        //保留的上一个版本中的表
        addNoteV2(schema);
        addCustomerOrderV2(schema);
        addPlayHistoryV2(schema);

        //修改的表
        addLocalPlayHistoryV2(schema);
        addAmericanNeighbourV2(schema);
        
        //新增的表
        addApkDownloadV2(schema);
        
        //删除的上一个版本中的表
        //LocalMedia

        try {
            new DaoGenerator().generateAll(schema, "../DaoExample/src-gen");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addNoteV1(Schema schema) {
        Entity note = schema.addEntity("Note");
        note.addIdProperty();
        note.addStringProperty("text").notNull();
        note.addStringProperty("comment");
        note.addDateProperty("date");
    }

    private static void addCustomerOrderV1(Schema schema) {
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

    private static void addLocalMediaV1(Schema schema) {
        Entity localMedia = schema.addEntity("LocalMedia");

        localMedia.addIdProperty();
        localMedia.addStringProperty("dir");
        localMedia.addStringProperty("file");
        localMedia.addIntProperty("size");
    }

    private static void addLocalPlayHistoryV1(Schema schema) {
        Entity lp = schema.addEntity("LocalPlayHistory");
        lp.addIdProperty();
        lp.addStringProperty("videoTitle");
        lp.addStringProperty("playedTime");
        lp.addIntProperty("tvLength");
        lp.addStringProperty("lastWatchTime");
        lp.addStringProperty("localUrl");
    }

    private static void addAmericanNeighbourV1(Schema schema) {
        Entity neighBour = schema.addEntity("AmericanNeighbour");
        neighBour.addIdProperty();
        neighBour.addIntProperty("channel_id");
        neighBour.addStringProperty("request_url");
        neighBour.addStringProperty("reponse");
        neighBour.addIntProperty("list_index");
        neighBour.addIntProperty("update_time");
        neighBour.addIntProperty("operation_type");
    }
    
    private static void addPlayHistoryV1(Schema schema) {
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
    
    private static void addNoteV2(Schema schema) {
        addNoteV1(schema);
    }
    
    private static void addCustomerOrderV2(Schema schema) {
        addCustomerOrderV1(schema);
    }

    private static void addLocalPlayHistoryV2(Schema schema) {
        Entity lp = schema.addEntity("LocalPlayHistory");
        lp.addIdProperty();
        lp.addStringProperty("videoTitle");
        lp.addStringProperty("playedTime");
        lp.addIntProperty("tvLength");
        lp.addStringProperty("lastWatchTime");
        lp.addStringProperty("localUrl");
        lp.addStringProperty("localUrlNew");//新增字段
    }

    private static void addAmericanNeighbourV2(Schema schema) {
        Entity neighBour = schema.addEntity("AmericanNeighbour");
        neighBour.addIdProperty();
        neighBour.addIntProperty("channel_id");
        neighBour.addStringProperty("request_url");
        neighBour.addStringProperty("reponse");
        neighBour.addIntProperty("list_index");
        neighBour.addIntProperty("update_time");
        neighBour.addIntProperty("operation_type");
        neighBour.addStringProperty("operation");//新增字段
    }
    
    private static void addApkDownloadV2(Schema schema) {
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

    private static void addPlayHistoryV2(Schema schema) {
        addPlayHistoryV1(schema);
    }

}
