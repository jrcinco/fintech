import Vue from 'vue';
import moment from 'moment-timezone';

Vue.filter('round', (value, decimals) => {
  if (!value) return '';
  const fixedDecimals = (decimals == null) ? 4 : decimals;
  return Number(value.toFixed(fixedDecimals));
});

Vue.filter('truncate', (text, stop, clamp) => text.slice(0, stop) + (stop < text.length ? clamp || '...' : ''));

Vue.filter('currency', (value) => {
  if (typeof value !== 'number') {
    return value;
  }
  const formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
    minimumFractionDigits: 2,
  });
  return formatter.format(value);
});

Vue.filter('dateFormat', date => moment(`${date}Z`).tz(moment.tz.guess()).format('MMMM DD, YYYY'));

Vue.filter('dateFormatMobile', date => moment(date).tz(moment.tz.guess()).format('MMM DD, YYYY'));

Vue.filter('commonDateFilter', date => moment(date).tz(moment.tz.guess()).format('MMMM DD, YYYY'));

Vue.filter('dateFormatHour', date => moment(`${date}`).tz(moment.tz.guess()).format('MMM DD, HH:mm A'));

Vue.filter('dateFormatBetween', (startDate, endDate) => {
  const startDateMonth = moment(`${startDate}`).tz(moment.tz.guess()).format('MMMM');
  const endDateMonth = moment(`${endDate}`).tz(moment.tz.guess()).format('MMMM');
  const startDateDay = moment(`${startDate}`).tz(moment.tz.guess()).format('D');
  const endDateDay = moment(`${endDate}`).tz(moment.tz.guess()).format('D');
  const startDateYear = moment(`${startDate}`).tz(moment.tz.guess()).format('YYYY');
  const endDateYear = moment(`${endDate}`).tz(moment.tz.guess()).format('YYYY');
  if (startDateYear !== endDateYear) {
    return `${startDateMonth} ${startDateDay}, ${startDateYear} - ${endDateMonth} ${endDateDay}, ${endDateYear}`;
  }
  if (startDateMonth !== endDateMonth) {
    return `${startDateMonth} ${startDateDay} - ${endDateMonth} ${endDateDay}, ${endDateYear}`;
  }
  if (startDateDay !== endDateDay) {
    return `${startDateMonth} ${startDateDay} - ${endDateDay}, ${startDateYear}`;
  }
  return `${startDateMonth} ${startDateDay}, ${startDateYear}`;
});
