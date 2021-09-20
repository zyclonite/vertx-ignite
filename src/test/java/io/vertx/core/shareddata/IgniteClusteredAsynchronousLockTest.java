/*
 * Copyright (c) 2015 The original author or authors
 * ---------------------------------
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * The Apache License v2.0 is available at
 * http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.core.shareddata;

import io.vertx.Lifecycle;
import io.vertx.LoggingTestWatcher;
import io.vertx.core.Vertx;
import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.ignite.IgniteClusterManager;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.List;

/**
 * @author Andrey Gura
 */
public class IgniteClusteredAsynchronousLockTest extends ClusteredAsynchronousLockTest {

  @Rule
  public LoggingTestWatcher watchman = new LoggingTestWatcher();

  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Override
  public void setUp() throws Exception {
    System.setProperty("IGNITE_HOME", temporaryFolder.newFolder().getAbsolutePath());
    super.setUp();
  }

  @Override
  protected ClusterManager getClusterManager() {
    return new IgniteClusterManager();
  }

  @Test
  @Override
  public void testLockReleasedForClosedNode() throws Exception {
    super.testLockReleasedForClosedNode();
  }

  @Test
  @Override
  public void testLockReleasedForKilledNode() throws Exception {
    super.testLockReleasedForKilledNode();
  }

  @Override
  protected void closeClustered(List<Vertx> clustered) throws Exception {
    Lifecycle.closeClustered(clustered);
  }
}
