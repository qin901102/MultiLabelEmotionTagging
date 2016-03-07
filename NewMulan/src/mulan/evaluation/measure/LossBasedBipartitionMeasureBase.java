/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    LossBasedBipartitionMeasureBase.java
 *    Copyright (C) 2009-2010 Aristotle University of Thessaloniki, Thessaloniki, Greece
 */
package mulan.evaluation.measure;

import mulan.evaluation.loss.BipartitionLossFunction;

/**
 *
 * @author Grigorios Tsoumakas
 * @version 2010.11.10
 */
public abstract class LossBasedBipartitionMeasureBase extends ExampleBasedBipartitionMeasureBase {

    // a bipartition loss function
    private final BipartitionLossFunction loss;

    /**
     * Creates a loss-based bipartition measure
     *
     * @param aLoss a bipartition loss function
     */
    public LossBasedBipartitionMeasureBase(BipartitionLossFunction aLoss) {
        loss = aLoss;
    }

    @Override
    public void updateBipartition(boolean[] bipartition, boolean[] truth) {
        sum += loss.computeLoss(bipartition, truth);
        count++;
    }

    public String getName() {
        return loss.getName();
    }

    public double getIdealValue() {
        return 0;
    }

}
