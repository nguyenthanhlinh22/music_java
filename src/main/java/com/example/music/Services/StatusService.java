package com.example.music.Services;

import com.example.music.Models.StatusModel;
import com.example.music.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private StatusModel statusModel;

    public StatusService() {
        this.statusModel = new StatusModel();
    }

    public List<Status> getAllStatus() throws SQLException {
        List<Status> statuses = new ArrayList<>();
        ResultSet resultSet = this.statusModel.getAllStatus();
        while (resultSet.next()) {
            int Statusid = resultSet.getInt("Statusid");
            String StatusName = resultSet.getString("StatusName");

            Status status = new Status(StatusName);
            status.setStatusid(Statusid);
            statuses.add(status);
        }
        return statuses;
    }
}
