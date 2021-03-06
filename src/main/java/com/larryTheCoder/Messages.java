/*
 * Copyright (C) 2016 larryTheHarry 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.larryTheCoder;

import com.larryTheCoder.utils.Utils;
import cn.nukkit.utils.Config;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Handles offline messaging to players and teams
 *
 * @author tastybento
 *
 */
public class Messages {

    private ASkyBlock plugin;
    // Offline Messages
    private HashMap<UUID, List<String>> messages = new HashMap<UUID, List<String>>();
    private Config messageStore;

    /**
     * @param plugin
     */
    public Messages(ASkyBlock plugin) {
        this.plugin = plugin;
    }

    /**
     * Returns what messages are waiting for the player or null if none
     *
     * @param playerUUID
     * @return List of messages
     */
    public List<String> getMessages(UUID playerUUID) {
        List<String> playerMessages = messages.get(playerUUID);
        return playerMessages;
    }

    /**
     * Clears any messages for player
     *
     * @param playerUUID
     */
    public void clearMessages(UUID playerUUID) {
        messages.remove(playerUUID);
    }

    public void saveMessages() {
        if (messageStore == null) {
            return;
        }
        plugin.getLogger().info("Saving offline messages...");
        try {
            // Convert to a serialized string
            final HashMap<String, Object> offlineMessages = new HashMap<>();
            messages.keySet().stream().forEach((p) -> {
                offlineMessages.put(p.toString(), messages.get(p));
            });
            // Convert to YAML
            messageStore.set("messages", offlineMessages);
            Utils.saveYamlFile(messageStore, "messages.yml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean loadMessages() {
        plugin.getLogger().info("Loading offline messages...");
        try {
            messageStore = Utils.loadYamlFile("messages.yml");
            if (messageStore.getSections("messages") == null) {
            }
            HashMap<String, Object> temp = messageStore.getSections("messages");
            temp.keySet().stream().forEach((s) -> {
                List<String> messageList = messageStore.getStringList("messages." + s);
                if (!messageList.isEmpty()) {
                    messages.put(UUID.fromString(s), messageList);
                }
            });

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Provides the messages for the player
     *
     * @param playerUUID
     * @return List of messages
     */
    public List<String> get(UUID playerUUID) {
        return messages.get(playerUUID);
    }

    /**
     * Stores a message for player
     *
     * @param playerUUID
     * @param playerMessages
     */
    public void put(UUID playerUUID, List<String> playerMessages) {
        messages.put(playerUUID, playerMessages);

    }

    /**
     * Sends a message to every player in the team that is offline
     *
     * @param playerUUID
     * @param message
     */
    public void tellOfflineTeam(UUID playerUUID, String message) {
//        // getLogger().info("DEBUG: tell offline team called");
//        //if (!plugin.getPlayers().inTeam(playerUUID)) {
//        //    // getLogger().info("DEBUG: player is not in a team");
//            return;
//        }
//        UUID teamLeader = plugin.getPlayers().getTeamLeader(playerUUID);
//        List<UUID> teamMembers = plugin.getPlayers().getMembers(teamLeader);
//        for (UUID member : teamMembers) {
//            // getLogger().info("DEBUG: trying UUID " + member.toString());
//            if (plugin.getServer().getPlayer(member) == null) {
//                // Offline player
//                setMessage(member, message);
//            }
//        }
    }

    /**
     * Tells all online team members something happened
     *
     * @param playerUUID
     * @param message
     */
    public void tellTeam(UUID playerUUID, String message) {
//        // getLogger().info("DEBUG: tell offline team called");
//        if (!plugin.getPlayers().inTeam(playerUUID)) {
//            // getLogger().info("DEBUG: player is not in a team");
//            return;
//        }
//        UUID teamLeader = plugin.getPlayers().getTeamLeader(playerUUID);
//        List<UUID> teamMembers = plugin.getPlayers().getMembers(teamLeader);
//        for (UUID member : teamMembers) {
//            // getLogger().info("DEBUG: trying UUID " + member.toString());
//            if (!member.equals(playerUUID) && plugin.getServer().getPlayer(member) != null) {
//                // Online player
//                plugin.getServer().getPlayer(member).sendMessage(message);
//            }
//        }
    }

    /**
     * Sets a message for the player to receive next time they login
     *
     * @param playerUUID
     * @param message
     * @return true if player is offline, false if online
     */
    public boolean setMessage(UUID playerUUID, String message) {
//        // getLogger().info("DEBUG: received message - " + message);
//        Player player = plugin.getServer().getPlayer(playerUUID);
//        // Check if player is online
//        if (player != null) {
//            if (player.isOnline()) {
//                // player.sendMessage(message);
//                return false;
//            }
//        }
//        // Player is offline so store the message
//        // getLogger().info("DEBUG: player is offline - storing message");
//        List<String> playerMessages = get(playerUUID);
//        if (playerMessages != null) {
//            playerMessages.add(message);
//        } else {
//            playerMessages = new ArrayList<String>(Arrays.asList(message));
//        }
//        put(playerUUID, playerMessages);
        return true;
    }
}
