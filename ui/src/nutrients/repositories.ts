import { apiUrl } from "../properties";

export const getNutrient = async (query: string) => {
  if (query !== "") {
    const endPoint = `${apiUrl}/nutrients?queryString=${query}`;

    const response: Response = await fetch(endPoint);

    if (response.status !== 200) {
      return {
        status: response.status
      };
    }

    const payload = await response.json();

    return {
      nutrient: payload,
      status: response.status
    };
  }
  return {
    nutrient: {}
  };
};
