## ADDED Requirements

### Requirement: Display metrics dashboard
The system SHALL display a single-screen dashboard containing a header with title and date range selector, main metric cards, a trend chart, and a recent activity table.

#### Scenario: Dashboard loads with default date range
- **WHEN** user accesses the dashboard
- **THEN** dashboard displays with default date range (last 7 days) and metric data

### Requirement: Date range selection updates data
The system SHALL update all displayed data when user changes the date range selection.

#### Scenario: User selects different date range
- **WHEN** user selects a different date range from the dropdown
- **THEN** all metric cards, trend chart, and activity table update to reflect data for selected range

### Requirement: Display metric cards
The system SHALL display 4 main metric cards showing: Total Users, Revenue, Conversion Rate, and Support Tickets.

#### Scenario: Metric cards display values
- **WHEN** dashboard renders with valid data
- **THEN** each metric card displays a label, current value, and trend indicator (up/down arrow with percentage)

### Requirement: Display trend chart
The system SHALL display a trend chart showing metric values over the selected date range.

#### Scenario: Chart renders with data points
- **WHEN** data is available for selected range
- **THEN** chart displays line or bar visualization with data points for each day/week

### Requirement: Display recent activity table
The system SHALL display a table showing recent user activities with columns: Date, User, Action, Status.

#### Scenario: Activity table displays entries
- **WHEN** activity data exists
- **THEN** table shows up to 10 most recent activities with date, user name, action description, and status badge

### Requirement: Show loading state
The system SHALL display a loading indicator while fetching or generating data.

#### Scenario: Loading state displays during data update
- **WHEN** user changes date range
- **THEN** loading spinner or skeleton appears on metric cards, chart, and table until data is ready

### Requirement: Show empty state
The system SHALL display an appropriate empty state when no data is available for the selected range.

#### Scenario: Empty state displays when no data
- **WHEN** selected date range has no data
- **THEN** each component displays a friendly empty message (e.g., "No data available for this period")