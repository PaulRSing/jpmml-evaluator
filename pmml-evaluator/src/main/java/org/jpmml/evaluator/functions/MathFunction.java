/*
 * Copyright (c) 2014 Villu Ruusmann
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
package org.jpmml.evaluator.functions;

import java.util.List;

import org.dmg.pmml.DataType;
import org.dmg.pmml.OpType;
import org.jpmml.evaluator.FieldValue;
import org.jpmml.evaluator.FieldValueUtil;

abstract
public class MathFunction extends AbstractFunction {

	public MathFunction(String name){
		super(name);
	}

	abstract
	public Double evaluate(Number value);

	public DataType getResultType(DataType dataType){
		return dataType;
	}

	@Override
	public FieldValue evaluate(List<FieldValue> arguments){
		checkArguments(arguments, 1);

		FieldValue value = arguments.get(0);

		DataType dataType = value.getDataType();

		Number result = evaluate(value.asNumber());

		return FieldValueUtil.create(getResultType(dataType), OpType.CONTINUOUS, result);
	}
}