/*
 * Copyright (c) 2016 Villu Ruusmann
 *
 * This file is part of JPMML-Evaluator
 *
 * JPMML-Evaluator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-Evaluator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-Evaluator.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.evaluator.mining;

import org.dmg.pmml.mining.MiningModel;
import org.dmg.pmml.mining.Segmentation;
import org.jpmml.evaluator.Consumer;

public interface MiningModelConsumer extends Consumer {

	/**
	 * <p>
	 * Gets the type of the {@link MiningModel}.
	 * </p>
	 *
	 * <p>
	 * The following {@link MiningModel} types propagate nested evaluation results to the top level:
	 * <ul>
	 *   <li>{@link Segmentation.MultipleModelMethod#SELECT_ALL}</li>
	 *   <li>{@link Segmentation.MultipleModelMethod#SELECT_FIRST}</li>
	 *   <li>{@link Segmentation.MultipleModelMethod#MODEL_CHAIN}</li>
	 * </ul>
	 * </p>
	 */
	Segmentation.MultipleModelMethod getMultipleModelMethod();
}