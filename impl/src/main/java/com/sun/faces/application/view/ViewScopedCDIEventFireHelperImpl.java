/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.application.view;

import java.io.Serializable;

import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Event;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

public class ViewScopedCDIEventFireHelperImpl implements Serializable, ViewScopedCDIEventFireHelper {

    private static final long serialVersionUID = 5777997951420156171L;

    @Inject
    @Initialized(ViewScoped.class)
    Event<UIViewRoot> viewScopeInitializedEvent;
    @Inject
    @Destroyed(ViewScoped.class)
    Event<UIViewRoot> viewScopeDestroyedEvent;

    @Override
    public void fireInitializedEvent(UIViewRoot root) {
        viewScopeInitializedEvent.fire(root);
    }

    @Override
    public void fireDestroyedEvent(UIViewRoot root) {
        viewScopeDestroyedEvent.fire(root);
    }

}
