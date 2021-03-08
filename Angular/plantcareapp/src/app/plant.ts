enum Status {
    Green,
    LightGreen,
    Yellow,
    Red
}

export interface Plant {
    id: number;
    name: string;
    lastWateredDate: string;
    wateringFreq: string;
    status: Status;
}