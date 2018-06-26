package com.dev.lvyou.web.controller.dto;



public class Location {
		public Double lat;
		public Double lng;
		
		@Override
		public String toString() {
			return "Location [lat=" + lat + ", lng=" + lng + "]";
		}
		public Double getLat() {
			return lat;
		}
		public void setLat(Double lat) {
			this.lat = lat;
		}
		public Double getLng() {
			return lng;
		}
		public void setLng(Double lng) {
			this.lng = lng;
		}
	}