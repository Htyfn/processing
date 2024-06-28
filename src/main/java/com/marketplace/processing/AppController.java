package com.marketplace.processing;

import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

    @RequestMapping(value = "/api/ping", method = RequestMethod.GET)
    public String ping() {
        return "pong";
    }
    /*
    @ResponseBody
    @RequestMapping(value = "/api/get_response",
            method = RequestMethod.POST,
            consumes = "text/xml; charset=utf-8",
            produces = "text/xml; charset=utf-8")
    public String getResponse(@RequestBody String inputXml) {
        Logger my_log = new Logger();

        my_log.saveReq(inputXml);
        String outputXml = OracleJdbc.getDbResponse(inputXml);
        my_log.saveResp(outputXml);

        return outputXml;
    }

    @RequestMapping(value = "/api/get_payments", method = RequestMethod.GET)
    public String GetPayments(String param) throws SQLException, ClassNotFoundException {
        Connection CacheConn = CacheJDBC.ConnectDB("Gateway");
        Connection OraConn = OracleJdbc.ConnectDB();
        try {
            return Export.GetPayments(CacheConn, OraConn, param);
        } catch (SQLException e) {
            CacheConn.close();
            OraConn.close();
            return "Error Code: " + ((SQLException)e).getErrorCode() + "; Message: " + e.getMessage();
        }
    }
    */
}