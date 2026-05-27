import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api/v1/flights';

export default class FlightRestService {

    saveFlight(flight) {
        return axios.post(BASE_URL, flight);
    }

    getFlights() {
        return axios.get(BASE_URL);
    }

    findByCode(code) {
        return axios.get(BASE_URL + '/' + code);
    }

    findByCarrier(carrier) {
        return axios.get(BASE_URL + '/carrier/' + carrier);
    }

    findByPrice(min, max) {
        return axios.get(BASE_URL + '/price?min=' + min + '&max=' + max);
    }

    findByRoute(source, destination) {
        return axios.get(
            BASE_URL +
            '/route?source=' +
            source +
            '&destination=' +
            destination
        );
    }

    deleteFlight(code) {
        return axios.delete(BASE_URL + '/' + code);
    }
}