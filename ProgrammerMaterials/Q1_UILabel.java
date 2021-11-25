/*******************************************************************************
 * Copyright (c) 2009, 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/
package org.eclipse.e4.ui.workbench;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.internal.ModelUtils;
import org.osgi.service.event.Event;



public static interface UILabel {

		// Topics that can be subscribed to

		@Deprecated
		public static final String TOPIC = "org/eclipse/e4/ui/model/ui/UILabel"; //$NON-NLS-1$

		public static final String TOPIC_ALL = "org/eclipse/e4/ui/model/ui/UILabel/*"; //$NON-NLS-1$
		public static final String TOPIC_ICONURI = "org/eclipse/e4/ui/model/ui/UILabel/iconURI/*"; //$NON-NLS-1$
		public static final String TOPIC_LABEL = "org/eclipse/e4/ui/model/ui/UILabel/label/*"; //$NON-NLS-1$
		public static final String TOPIC_TOOLTIP = "org/eclipse/e4/ui/model/ui/UILabel/tooltip/*"; //$NON-NLS-1$
		public static final String TOPIC_BUSY = "org/eclipse/e4/ui/model/ui/UILabel/busy"; //$NON-NLS-1$

		// Attributes that can be tested in event handlers
		public static final String ICONURI = "iconURI"; //$NON-NLS-1$
		public static final String LABEL = "label"; //$NON-NLS-1$
		public static final String TOOLTIP = "tooltip"; //$NON-NLS-1$
		public static final String BUSY = "busy"; //$NON-NLS-1$
}

