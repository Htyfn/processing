package com.marketplace.processing;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class AppController {

    @RequestMapping(value = "/api/ping", method = RequestMethod.GET)
    public String ping() {
        return "pong";
    }

    @ResponseBody
    @RequestMapping(value = "/api/payment",
            method = RequestMethod.POST,
            consumes = "text/xml; charset=utf-8",
            produces = "text/xml; charset=utf-8")
    public String getResponse(@RequestBody String rq_body) throws SQLException, ClassNotFoundException {
        Connection db = null;
        try {
            db = OracleJdbc.ConnectDB();
            return Payment.Post(db, rq_body);
        } catch (SQLException e) {
            if (!(db == null)) {
                db.close();
            }
            return "Error Code: " + ((SQLException)e).getErrorCode() + "; Message: " + e.getMessage();
        }
    }
    
    @RequestMapping(value = "/api/get_payments", method = RequestMethod.GET)
    public String GetPayments(String param) throws SQLException, ClassNotFoundException {
        Connection db = null;
        try {
            db = OracleJdbc.ConnectDB();
            return Export.GetPayments(db, param);
        } catch (SQLException e) {
            if (!(db == null)) {
                db.close();
            }
            return "Error Code: " + ((SQLException)e).getErrorCode() + "; Message: " + e.getMessage();
        }
    }
}