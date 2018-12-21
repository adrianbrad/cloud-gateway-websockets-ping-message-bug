package com.adrianbrad.websocketsserver;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller extends AbstractWebSocketHandler {

    private static final int ANALYZE_EVERY = 5 * 1000; // How often to scan for connections needing, milliseconds

    private List<WebSocketSession> managedConnections = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("New WebSocket session: " + session);
        managedConnections.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Session: " + session + " closed");
        managedConnections.remove(session);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.out.println("Transport Error");
        session.close();
        managedConnections.remove(session);
    }

    @Scheduled(fixedRate = ANALYZE_EVERY)
    public void keepInactiveConnectionsAlive() {
        managedConnections
                .forEach(this::sendPingMessage);
    }

    private void sendPingMessage(WebSocketSession session) {
        System.out.println("Sending ping message to session: " + session);
        try {
            session.sendMessage(new PingMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
