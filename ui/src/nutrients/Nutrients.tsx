import { Table } from "react-bootstrap";

import React from "react";
import { Nutrient } from "./model";
import { connectNutrient } from "./NutrientsConnector"

export type NutrientsBaseProps = {
    nutrient: Nutrient
};

export const NutrientsBase: React.FC<NutrientsBaseProps> = (props: NutrientsBaseProps) =>
    <Table striped bordered hover size="sm">
        <thead>
            <tr>
                <th>Ingredients</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                {props.nutrient.nutrientsList.map((nutrient, idx) => <td key={idx}>nutrient</td>)}
            </tr>
        </tbody>
    </Table>

export const Nutrients = connectNutrient(NutrientsBase);