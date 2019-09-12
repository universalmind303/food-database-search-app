import {apiUrl} from '../properties';

export const getProducts = async (query: string) => {
    const endPoint = `${apiUrl}/products?queryString=${query}`;

    const response: Response = await fetch(endPoint);
    
    if (response.status !== 200) {
        return {
            status: response.status
        };
    }

    const payload = await response.json();

    return {
        products: payload,
        status: response.status
    };
};
