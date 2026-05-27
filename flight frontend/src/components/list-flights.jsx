import React, { Component } from 'react';
import FlightRestService from '../services/flight-rest-service';
import './flight.css';

export default class ListFlights extends Component {

    constructor(props) {
        super(props);

        this.service = new FlightRestService();

        this.state = {
            flights: []
        };
    }

    componentDidMount() {

        this.service.getFlights()
            .then((response) => {

                this.setState({
                    flights: response.data
                });

            })
            .catch(() => {

                alert("Unable To Load Flights");

            });
    }

    deleteFlight = (code) => {

        this.service.deleteFlight(code)
            .then(() => {

                alert("Flight Deleted");

                this.setState({

                    flights: this.state.flights.filter(
                        (flight) => flight.code !== code
                    )

                });

            })
            .catch(() => {

                alert("Delete Failed");

            });

    }

    render() {

        return (

            <div className='page-container'>

                <div className='flight-grid'>

                    {
                        this.state.flights.map((flight) => (

                            <div
                                className='flight-card'
                                key={flight.code}
                            >

                                <h3>
                                    {flight.carrier}
                                </h3>

                                <div className='route'>

                                    {flight.source}
                                    &nbsp; ✈ &nbsp;
                                    {flight.destination}

                                </div>

                                <div className='price'>

                                    ₹ {flight.cost}

                                </div>

                                <p style={{marginTop:'10px'}}>

                                    Flight Code : {flight.code}

                                </p>

                                <button
                                    className='delete-btn'
                                    onClick={() => this.deleteFlight(flight.code)}
                                >
                                    Delete Flight
                                </button>

                            </div>

                        ))
                    }

                </div>

            </div>

        );
    }
}