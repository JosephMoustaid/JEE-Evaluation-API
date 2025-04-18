# Charity Application API

A Spring Boot application for managing charity campaigns and donations.

## Database Schema

### Campaigns Table
![Campaigns Database Schema](campagnes%20-%20db.png)

### Donations Table
![Donations Database Schema](donations-%20db.png)

## API Endpoints

### 1. Get Active Campaigns
- **Endpoint:** `GET /api/campagnes/actives`
- **Description:** Retrieves all active charity campaigns
- **Response:** List of active campaigns with their details
- **Test Result:**
  ![Get Campaigns Test](route%201%20test%20-%20using%20postman%20-%20get%20campangs.png)

### 2. Create Donation
- **Endpoint:** `POST /api/campagnes/{id}/dons`
- **Description:** Creates a new donation for a specific campaign
- **Request Body:** Json of the dto
-   ![Get Campaigns Test](route%202%20test-%20usig%20postman%20-%20post%20don.png)
