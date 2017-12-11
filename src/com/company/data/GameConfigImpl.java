package com.company.data;

import com.company.utils.Configurator;
import com.company.enums.Direction;
import com.company.interfaces.GameConfig;
import com.company.interfaces.Position;

import java.util.*;

public class GameConfigImpl implements GameConfig {

    private HashMap<String, Object> config = new HashMap();

    public GameConfigImpl() {
        Properties gameSettings = Configurator.readConfigFile(Configurator.gameSettingsFile);
        Properties moves = Configurator.readConfigFile(Configurator.moves);

        int[] mazeDimensions = Arrays.asList(gameSettings.getProperty("size")
                .split(","))
                .stream()
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        // retrieve starting point
        Position startingPosition = new PositionImpl(Integer.parseInt(gameSettings.getProperty("startX")),
                Integer.parseInt(gameSettings.getProperty("startY")),
                Direction.valueOf(gameSettings.getProperty("direction")));
        //retrieve exit point
        Position exit = new PositionImpl(Integer.parseInt(gameSettings.getProperty("exitX")), Integer.parseInt(gameSettings.getProperty("exitY")));
        String[] gameMoves = moves.getProperty("moves").split(",");
        List<Position> mines = getMinesAsList(gameSettings.getProperty("mines").split(";"));

        //add to config object
        config.put("mazeDimensions", mazeDimensions);
        config.put("startingPosition", startingPosition);
        config.put("moves", gameMoves);
        config.put("exit", exit);
        config.put("mines", mines);
    }

    public HashMap getConfig() {
        return this.config;
    }

    private List<Position> getMinesAsList(String[] arr) {
        List<Position> positions = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            int x = Integer.parseInt(arr[i].substring(0, arr[i].indexOf(",")));
            int y = Integer.parseInt(arr[i].substring(arr[i].indexOf(",") + 1));
            positions.add(new PositionImpl(x, y));
        }
        return positions;
    }

}
