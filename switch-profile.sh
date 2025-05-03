#!/bin/bash
cd "$(dirname "$0")"

# Check if both services exist
if [ ! -d "contact-fetch-service" ] || [ ! -d "contact-save-service" ]; then
  echo "Please run this script from the directory containing both microservices."
  exit 1
fi

echo "Enter Spring environment (t01, t02, t03, prod):"
read inputProfile

case "$inputProfile" in
  t01)
    PROFILE="t01"
    ;;
  t02)
    PROFILE="t02"
    ;;
  t03)
    PROFILE="t03"
    ;;
  prod)
    PROFILE="prod"
    ;;
  *)
    echo "Invalid profile. Please enter one of: t01, t02, t03, prod."
    exit 1
    ;;
esac

# Branch switching removed -- perform manual branch switching if needed.

(
  cd contact-fetch-service
  mvn spring-boot:run -Dspring-boot.run.profiles=$PROFILE
) &
FETCH_PID=$!

(
  cd contact-save-service
  mvn spring-boot:run -Dspring-boot.run.profiles=$PROFILE
) &
SAVE_PID=$!

wait $FETCH_PID
FETCH_STATUS=$?
wait $SAVE_PID
SAVE_STATUS=$?

if [ $FETCH_STATUS -ne 0 ]; then
  echo "Error: contact-fetch-service failed to start."
  exit 3
fi

if [ $SAVE_STATUS -ne 0 ]; then
  echo "Error: contact-save-service failed to start."
  exit 4
fi

echo "Started contact-fetch-service and contact-save-service with profile: $PROFILE"