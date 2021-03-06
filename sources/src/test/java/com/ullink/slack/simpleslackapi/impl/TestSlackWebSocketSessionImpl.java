package com.ullink.slack.simpleslackapi.impl;

import com.ullink.slack.simpleslackapi.SlackChannel;
import com.ullink.slack.simpleslackapi.WebSocketContainerProvider;
import mockit.Mocked;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestSlackWebSocketSessionImpl {

  @Test(expected = IllegalArgumentException.class)
  public void testSendMessageWithNullChanel(@Mocked WebSocketContainerProvider provider) throws Exception{
    SlackWebSocketSessionImpl webSocketSession = new SlackWebSocketSessionImpl(provider, "", null, false, false, 42L, TimeUnit.MILLISECONDS);
    SlackChannel channel = null;
    try {
      webSocketSession.sendMessage(channel, "");
    } catch (NullPointerException e) {
      fail("NullPointerException unexpected here");
    }
  }
}
