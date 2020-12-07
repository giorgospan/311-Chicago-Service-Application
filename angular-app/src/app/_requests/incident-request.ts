export class IncidentRequest {

  status: string;
  requestNumber: string;
  requestType: string;
  streetAddress: string;
  zipCode: string;
  ward: number;
  policeDistrict: number;
  communityArea: number;
  historicalWards: number;
  zipCodes: string;
  communityAreas: number;
  censusTracts: number;
  wards: number;
  xCoordinate: number;
  yCoordinate: number;
  latitude: number;
  longitude: number;
  enumRequestType;

  currentActivity: string;
  mostRecentAction: string;
  ssa: number;

  premisesBaited: number;
  premisesWithGarbage: number;
  premisesWithRats: number;
  potholesFilled: number;

  numOfBlackCarts: number;

  graffitiSurface: string;
  graffitiLocation: string;

  nature: string;
  treeLocation: string;

  daysParked: number;
  licencePlate: string;
  vehicleColor: string;
  vehicleModel: string;
}
